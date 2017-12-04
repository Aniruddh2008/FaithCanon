package faithcanon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.faithcanon.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by A12PCHBR on 11/21/2017.
 */

public class LoginTypes extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.email)
    TextView emailClick;
    @BindView(R.id.feedback)
    TextView feedback;
    @BindView(R.id.terms)
    TextView terms;
    @BindView(R.id.privacy)
    TextView privacy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_types_view);
        ButterKnife.bind(this);
        emailClick.setOnClickListener(this);
        feedback.setOnClickListener(this);
        terms.setOnClickListener(this);
        privacy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.email:
                Intent i1 = new Intent(this, LoginActivity.class);
                startActivity(i1);
                break;
            case R.id.feedback:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("plain/text");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"recepient@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Test");
                i.putExtra(Intent.EXTRA_TEXT, Html.fromHtml("hiii"));
                try {
                    startActivity(i);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this, "There are no email applications installed.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.privacy:
                Toast.makeText(this,"Privacy Policy",Toast.LENGTH_SHORT).show();
                break;
            case R.id.terms:
                Toast.makeText(this,"Terms",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
