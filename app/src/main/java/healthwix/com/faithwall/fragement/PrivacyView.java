package healthwix.com.faithwall.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import healthwix.com.faithwall.R;
import healthwix.com.faithwall.activity.MainActivity;

/**
 * Created by a12pchbr on 11/27/2017.
 */

public class PrivacyView extends Fragment implements View.OnClickListener {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.post_type_selection, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initViews(view);
    }



    private void initViews(View view) {
        ((MainActivity)getActivity()).enableViews(true);
        ((MainActivity)getActivity()).hideShowTopLayout(true);
        ((MainActivity)getActivity()).hideShowFeedback(false);
     // WebView  webView = (WebView) view.findViewById(R.id.webView1);
       // webView.getSettings().setJavaScriptEnabled(true);
       // webView.loadUrl("http://www.google.com");

    }



    @Override
    public void onClick(View v) {

        Toast.makeText(getContext(),"Password Changed",Toast.LENGTH_SHORT).show();

    }



}
