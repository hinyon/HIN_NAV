package com.example.android.navigationdrawerexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;


public class PageSlidingTabStripFragment extends Fragment {

	/*HIN:newInstance()һ������Ӳ���ûʲô����,����һ�㶼����,����������driverName���������,��Ϊ������'ȫ��'��ʵ��,
	���ֻ��driverName dn = new driverName();
	��ֻ���ڵ��ô���ʱ�Ż�װ���������,���������ܻᱻ�����������*/
	
/*	public static final String TAG = PageSlidingTabStripFragment.class
			.getSimpleName();

	public static PageSlidingTabStripFragment newInstance() {
		return new PageSlidingTabStripFragment();
	}*/
	
	
	//��ʹ����򵥵Ĺ��캯����	
	public PageSlidingTabStripFragment() {
		// Empty constructor required for fragment subclasses
	}
	
	///////

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.pager, container, false);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view
				.findViewById(R.id.tabs);
		ViewPager pager = (ViewPager) view.findViewById(R.id.pager);
		MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
		pager.setAdapter(adapter);
		tabs.setViewPager(pager);

	}

	public class MyPagerAdapter extends FragmentPagerAdapter {

		public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
			super(fm);
		}

		private final String[] TITLES = { "Categories", "Home", "Top Paid",
				"Top Free" };

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}
		
		//������ʱ������Fragment
		@Override
		public Fragment getItem(int position) {
			return SuperAwesomeCardFragment.newInstance(position);
				
		}

	}


}
