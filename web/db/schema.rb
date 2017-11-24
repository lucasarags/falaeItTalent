# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20171118020238) do

  create_table "categories", force: :cascade do |t|
    t.string "name", null: false
    t.string "color"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.string "description"
    t.index ["name"], name: "index_categories_on_name", unique: true
  end

  create_table "category_items", force: :cascade do |t|
    t.integer "category_id"
    t.integer "item_id"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["category_id"], name: "index_category_items_on_category_id"
    t.index ["item_id"], name: "index_category_items_on_item_id"
  end

  create_table "images", force: :cascade do |t|
    t.string "type"
    t.string "image_file_name"
    t.string "image_content_type"
    t.integer "image_file_size"
    t.datetime "image_updated_at"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["image_file_name"], name: "index_images_on_image_file_name"
  end

  create_table "item_pages", force: :cascade do |t|
    t.integer "item_id"
    t.integer "page_id"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.string "link_to"
    t.index ["item_id"], name: "index_item_pages_on_item_id"
    t.index ["page_id"], name: "index_item_pages_on_page_id"
  end

  create_table "item_users", force: :cascade do |t|
    t.integer "item_id"
    t.integer "user_id"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["item_id"], name: "index_item_users_on_item_id"
    t.index ["user_id"], name: "index_item_users_on_user_id"
  end

  create_table "items", force: :cascade do |t|
    t.string "name", null: false
    t.string "speech", null: false
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.boolean "default", default: false
    t.string "image_file_name"
    t.string "image_content_type"
    t.integer "image_file_size"
    t.datetime "image_updated_at"
  end

  create_table "pages", force: :cascade do |t|
    t.string "name", null: false
    t.integer "columns"
    t.integer "rows"
    t.integer "spreadsheet_id"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["spreadsheet_id"], name: "index_pages_on_spreadsheet_id"
  end

  create_table "role_users", force: :cascade do |t|
    t.integer "role_id"
    t.integer "user_id"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["role_id"], name: "index_role_users_on_role_id"
    t.index ["user_id"], name: "index_role_users_on_user_id"
  end

  create_table "roles", force: :cascade do |t|
    t.string "name", null: false
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["name"], name: "index_roles_on_name", unique: true
  end

  create_table "spreadsheets", force: :cascade do |t|
    t.string "name", null: false
    t.string "initial_page"
    t.integer "user_id"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["user_id"], name: "index_spreadsheets_on_user_id"
  end

  create_table "users", force: :cascade do |t|
    t.string "name"
    t.string "last_name"
    t.string "email", null: false
    t.string "password_digest", null: false
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.string "activation_digest"
    t.boolean "activated", default: false
    t.datetime "activated_at"
    t.string "reset_digest"
    t.datetime "reset_sent_at"
    t.text "profile"
    t.string "photo_file_name"
    t.string "photo_content_type"
    t.integer "photo_file_size"
    t.datetime "photo_updated_at"
    t.string "auth_token"
    t.datetime "auth_token_created_at"
    t.index ["auth_token", "auth_token_created_at"], name: "index_users_on_auth_token_and_auth_token_created_at"
    t.index ["email"], name: "index_users_on_email", unique: true
  end

end
