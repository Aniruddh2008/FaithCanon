package faithcanon.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faithcanon.R;

import butterknife.ButterKnife;
import faithcanon.activity.MainActivity;

/**
 * Created by A12PCHBR on 11/21/2017.
 */

public class PostScreenView extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.post_screen_view, container, false);
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
        ((MainActivity)getActivity()).hideShowFeedback(true);

    }



    @Override
    public void onClick(View v) {

    }



}

