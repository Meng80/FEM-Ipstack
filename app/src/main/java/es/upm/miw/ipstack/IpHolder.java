package es.upm.miw.ipstack;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class IpHolder extends RecyclerView.ViewHolder {

    private final TextView tvIp;

    public IpHolder(@NonNull View itemView) {
        super(itemView);
        tvIp = itemView.findViewById(R.id.tvIpstackInfo);
    }

    public void bind(@NonNull IpHistory ipHistory) {
        setIp(ipHistory.toString());
    }

    private void setIp(@NonNull String ip){
        tvIp.setText(ip);
    }
}