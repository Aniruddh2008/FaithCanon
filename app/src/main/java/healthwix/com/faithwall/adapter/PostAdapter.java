package healthwix.com.faithwall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import healthwix.com.faithwall.R;
import healthwix.com.faithwall.activity.MainActivity;
import healthwix.com.faithwall.fragement.CommentView;


/**
 * Created by A12PCHBR on 11/10/2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private Context mContext;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_row, parent, false);
        return new ViewHolder(view);
    }

    public PostAdapter(Context mContext) {
        this.mContext = mContext;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.commentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommentView commentView=new CommentView();
                ((MainActivity)mContext).addFragementView(commentView);
            }
        });
        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommentView commentView=new CommentView();
                ((MainActivity)mContext).addFragementView(commentView);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView commentView,comment;

        public ViewHolder(View itemView) {
            super(itemView);
            commentView = (TextView) itemView.findViewById(R.id.comment_view);
            comment = (TextView) itemView.findViewById(R.id.comment);
        }
    }
}