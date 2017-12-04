package healthwix.com.faithwall.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import healthwix.com.faithwall.R;
import healthwix.com.faithwall.activity.MainActivity;
import healthwix.com.faithwall.adapter.FriendListAdapter;

/**
 * Created by A12PCHBR on 11/21/2017.
 */

public class ProfileView extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_profile, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initViews(view);
    }



    private void initViews(View view) {
        //postLayout.setVisibility(View.GONE);
        ((MainActivity)getActivity()).enableViews(true);
        ((MainActivity)getActivity()).hideShowTopLayout(true);

        ((MainActivity)getActivity()).hideShowFeedback(false);
    }



    @Override
    public void onClick(View v) {

    }



}

