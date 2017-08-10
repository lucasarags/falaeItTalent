class SessionsController < ApplicationController
  def new
  end

  def create
    @user = User.find_by(email: session_params[:email].downcase)
    if @user && @user.authenticate(session_params[:password])
      if @user.activated?
        log_in @user
        respond_to do |format|
          format.html { redirect_to user_spreadsheets_path(@user) }
          format.json {
            render template: 'users/show', location: @user
            log_out
          }
        end
      else
        flash.now[:warning] = t('user_mailer.account_activation.notactivated')
        respond_to do |format|
          format.html { render :new }
          format.json { unauthorized_json_access }
        end
      end
    else
      flash.now[:alert] = t('flash.error.wrong_email_password')
      respond_to do |format|
        format.html { render :new }
        format.json { unauthorized_json_access }
      end
    end
  end

  def destroy
    log_out
    redirect_to root_path
  end

  private
    def session_params
      basic_authentication || params.require(:user).permit(:email, :password)
    end

    def basic_authentication
      if request.format.json?
        authenticate_with_http_basic do |email, password|
          {email: email, password: password}
        end
      end
    end
end
