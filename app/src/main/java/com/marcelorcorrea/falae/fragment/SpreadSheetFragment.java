package com.marcelorcorrea.falae.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marcelorcorrea.falae.R;
import com.marcelorcorrea.falae.adapter.SpreadSheetAdapter;
import com.marcelorcorrea.falae.model.SpreadSheet;
import com.marcelorcorrea.falae.model.User;


public class SpreadSheetFragment extends Fragment {

    private static final String USER_PARAM = "userParam";

    private OnFragmentInteractionListener mListener;
    private SpreadSheetAdapter spreadSheetAdapter;
    private User user;

    public SpreadSheetFragment() {
    }

    public static SpreadSheetFragment newInstance(User user) {
        SpreadSheetFragment fragment = new SpreadSheetFragment();
        Bundle args = new Bundle();
        args.putParcelable(USER_PARAM, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = getArguments().getParcelable(USER_PARAM);
        }
        onAttachFragment(getParentFragment());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spread_sheet, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.spreadsheet_recycler);
        spreadSheetAdapter = new SpreadSheetAdapter(getContext(), user.getSpreadsheets(), new SpreadSheetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SpreadSheet spreadSheet) {
                mListener.displayActivity(spreadSheet);
            }
        });
        recyclerView.setAdapter(spreadSheetAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) fragment;
        } else {
            throw new RuntimeException(fragment.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void displayActivity(SpreadSheet spreadSheet);
    }
}
