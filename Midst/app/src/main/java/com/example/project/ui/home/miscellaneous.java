package com.example.project.ui.home;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import com.example.project.R;
import static java.lang.System.exit;

public class miscellaneous extends Fragment implements View.OnClickListener
{

    private MiscellaneousViewModel mViewModel;
    public static miscellaneous newInstance() {
        return new miscellaneous();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.miscellaneous_fragment, container, false);

        /* Buttons */

        Button button1 = root.findViewById(R.id.hostels);
        Button button2 = root.findViewById(R.id.placement);
        Button button3 = root.findViewById(R.id.admission);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        /*Video*/

        MediaController mc = new MediaController(getActivity());
        VideoView videoView = root.findViewById(R.id.video);
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.clip;
        videoView.setVideoURI(Uri.parse(path));
        videoView.setMediaController(mc);
        videoView.start();

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hostels:
                Intent hostel_browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://lmtsm.thapar.edu/index.php/a-z-directory/17-rss-feed/35-infrastructure"));
                startActivity(hostel_browserIntent);
                break;
            case R.id.placement:
                Intent placement_browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.thapar.edu/placements"));
                startActivity(placement_browserIntent);
                break;
            case R.id.admission:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://admissions.thapar.edu"));
                startActivity(browserIntent);
                break;
            default: exit(1);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MiscellaneousViewModel.class);
        // TODO: Use the ViewModel
    }
}