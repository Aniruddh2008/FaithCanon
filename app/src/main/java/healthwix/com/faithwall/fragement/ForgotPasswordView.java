package healthwix.com.faithwall.fragement;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import healthwix.com.faithwall.R;
import healthwix.com.faithwall.activity.MainActivity;

/**
 * Created by a12pchbr on 11/27/2017.
 */

public class ForgotPasswordView extends Fragment implements View.OnClickListener {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forgot_password_view, container, false);
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
        SpannableString content = new SpannableString("Forgot Password ?");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        //forgotPassword.setText(content);

    }



    @Override
    public void onClick(View v) {

        Toast.makeText(getContext(),"Password Changed ",Toast.LENGTH_SHORT).show();

    }



}
