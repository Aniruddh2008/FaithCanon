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
import healthwix.com.faithwall.adapter.PostAdapter;

/**
 * Created by A12PCHBR on 11/21/2017.
 */

public class PostView  extends Fragment implements View.OnClickListener {
    @BindView(R.id.post_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.post_layout)
    LinearLayout postLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.post_view, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initViews(view);
    }



    private void initViews(View view) {
        ((MainActivity)getActivity()).enableViews(false);
        ((MainActivity)getActivity()).hideShowTopLayout(false);
        ((MainActivity)getActivity()).hideShowFeedback(true);
        postLayout.setVisibility(View.VISIBLE);
        postLayout.setOnClickListener(this);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        PostAdapter mPostAdapter = new PostAdapter(getActivity());
        mRecyclerView.setAdapter(mPostAdapter);


    }



    @Override
    public void onClick(View v) {
        PostScreenView mPostScreenView=new PostScreenView();
        ((MainActivity)getActivity()).addFragementView(mPostScreenView);

    }



}
