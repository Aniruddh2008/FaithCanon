package healthwix.com.faithwall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import healthwix.com.faithwall.R;


/**
 * Created by A12PCHBR on 11/10/2017.
 */

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.ViewHolder> {

    private Context mContext;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.frd_list_row, parent, false);
        return new ViewHolder(view);
    }

    public FriendListAdapter(Context mContext) {
        this.mContext = mContext;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView pName;

        public ViewHolder(View itemView) {
            super(itemView);
            pName = (TextView) itemView.findViewById(R.id.name);
        }
    }
}