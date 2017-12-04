package healthwix.com.faithwall.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import healthwix.com.faithwall.R;
import healthwix.com.faithwall.activity.MainActivity;
import healthwix.com.faithwall.adapter.CommentAdapter;

/**
 * Created by a12pchbr on 11/27/2017.
 */

public class SettingView extends Fragment implements View.OnClickListener {
    @BindView(R.id.change_password)
    TextView changePassword;
    @BindView(R.id.privacy)
    TextView privacy;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_screen, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initViews(view);
    }


    private void initViews(View view) {
        ((MainActivity) getActivity()).enableViews(true);
        ((MainActivity) getActivity()).hideShowTopLayout(true);
        ((MainActivity)getActivity()).hideShowFeedback(false);
        changePassword.setOnClickListener(this);
        privacy.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.change_password:
                ChangePasswordView mChangePasswordView = new ChangePasswordView();
                ((MainActivity) getActivity()).addFragementView(mChangePasswordView);
                break;
            case R.id.privacy:
                PrivacyView mPrivacyView = new PrivacyView();
                ((MainActivity) getActivity()).addFragementView(mPrivacyView);
                break;

        }

    }


}
