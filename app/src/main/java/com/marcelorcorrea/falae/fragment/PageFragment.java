package com.marcelorcorrea.falae.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marcelorcorrea.falae.R;
import com.marcelorcorrea.falae.adapter.ItemPagerAdapter;
import com.marcelorcorrea.falae.model.Page;
import com.marcelorcorrea.falae.model.SpreadSheet;


public class PageFragment extends Fragment implements ItemFragment.OnFragmentInteractionListener {
    private static final String SPREADSHEET_PARAM = "spreadsheetParam";
    private static final String PAGE_PARAM = "pageParam";

    private Page page;
    private SpreadSheet spreadSheet;
    private OnFragmentInteractionListener mListener;
    private ViewPager mPager;
    private ItemPagerAdapter mPagerAdapter;

    public PageFragment() {
    }

    public static PageFragment newInstance(SpreadSheet spreadSheet, Page page) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putParcelable(PAGE_PARAM, page);
        args.putParcelable(SPREADSHEET_PARAM, spreadSheet);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            page = getArguments().getParcelable(PAGE_PARAM);
            spreadSheet = getArguments().getParcelable(SPREADSHEET_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPagerAdapter = new ItemPagerAdapter(getChildFragmentManager(), page);
        mPager.setAdapter(mPagerAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onStop() {
        super.onStop();
        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.show();
        }
    }

    @Override
    public void openPageFragment(String linkTo) {
        mListener.openPageFragment(spreadSheet, linkTo);
    }

    public interface OnFragmentInteractionListener {
        void openPageFragment(SpreadSheet spreadSheet, String linkTo);
    }
}
