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
import android.widget.EditText;
import android.widget.TextView;
import com.example.project.R;
import static java.lang.System.exit;

public class faculty extends Fragment implements View.OnClickListener {
    private FacultyViewModel mViewModel;

    private EditText fac, std;
    private TextView textView;

    String name="";

    public static faculty newInstance() {
        return new faculty();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.faculty_fragment, container, false);

        /*faculty login*/

        fac = root.findViewById(R.id.emp_number);
        Button button1 = root.findViewById(R.id.confirm);
        textView = root.findViewById(R.id.emp_confirm);

        /*student details*/

        std = root.findViewById(R.id.stud_name);
        Button button2 = root.findViewById(R.id.stud_details);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.confirm:
                int facno = Integer.parseInt(fac.getText().toString());
                switch (facno) {
                    case 101816006:
                    case 101816008:
                    case 101816016:
                    case 101816019:
                    case 101816030:
                        name = "Deep Mann";
                        break;
                    default: exit(1);
                }
                textView.setText(name);
                break;
            case R.id.stud_details:
                String stdname="";
                stdname = std.getText().toString();
                if(name == "Deep Mann") {
                    switch (stdname) {
                        case "Divyank Singh":
                        case "Ishita Krishnatray":
                        case "Mehak Dhir":
                        case "Siddharth Budhwar":
                        case "Tushar Riyat":
                            Intent fee_browserIntent = new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://webkiosk.thapar.edu/index.jsp?_" +
                                            "ga=2.168427297.141322623.1588653363-675121206" +
                                            ".1576325197"));
                            startActivity(fee_browserIntent);
                            break;
                        default: exit(1);
                    }
                }
                else exit(1);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FacultyViewModel.class);
        // TODO: Use the ViewModel
    }
}