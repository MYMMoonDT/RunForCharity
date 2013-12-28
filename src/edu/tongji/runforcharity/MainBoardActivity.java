package edu.tongji.runforcharity;

import edu.tongji.runforcharity.layout.BidirSlidingLayout;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainBoardActivity extends Activity implements OnItemClickListener{
	
	private BidirSlidingLayout bidirSldingLayout;
	
	private ListView contentList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mainboard);
		contentList = (ListView) findViewById(R.id.contentList);
		contentList.setOnItemClickListener(this);
		bidirSldingLayout = (BidirSlidingLayout) findViewById(R.id.bidir_sliding_layout);
		bidirSldingLayout.setScrollEvent(contentList);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		switch (arg0.getId())
        {
        case R.id.rightcontentList:
            bidirSldingLayout.showOrHideRightMenu();
            break;
        case R.id.leftcontentList:
            bidirSldingLayout.showOrHideLeftMenu();
            break;
        case R.id.contentList:
            break;
        }
	}
}
