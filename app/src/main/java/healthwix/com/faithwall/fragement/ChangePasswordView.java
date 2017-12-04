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

public class ChangePasswordView extends Fragment implements View.OnClickListener {
    @BindView(R.id.save_changes)
    TextView saveChanges;
    @BindView(R.id.forgot_password)
    TextView forgotPassword;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.change_password, container, false);
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
        saveChanges.setOnClickListener(this);
        SpannableString content = new SpannableString("Forgot Password ?");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        //forgotPassword.setText(content);
        forgotPassword.setPaintFlags(forgotPassword.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        forgotPassword.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.forgot_password:
                ForgotPasswordView mForgotPasswordView=new ForgotPasswordView();
                ((MainActivity)getActivity()).addFragementView(mForgotPasswordView);
                break;
        }

        Toast.makeText(getContext(),"Password Changed ",Toast.LENGTH_SHORT).show();

    }



}
