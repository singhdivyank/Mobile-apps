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

public class student extends Fragment implements View.OnClickListener {

    private EditText editText;
    private TextView textView;

    private String stdname="";
    private int rollnumber = 0;

    public static student newInstance() {
        return new student();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.student_fragment, container, false);

        /*student login*/

        editText = root.findViewById(R.id.roll_number);
        Button button1 = root.findViewById(R.id.std_confirm);
        textView = root.findViewById(R.id.student_confirm);

        /*Buttons*/

        Button button2 = root.findViewById(R.id.faculty);
        Button button3 = root.findViewById(R.id.books);
        Button button4 = root.findViewById(R.id.curriculum);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.std_confirm:
                rollnumber = Integer.parseInt(editText.getText().toString());
                switch(rollnumber) {
                    case 101816006:
                        stdname = "Divyank Singh";
                        break;
                    case 101816008:
                        stdname = "Mehak Dhir";
                        break;
                    case 101816016:
                        stdname = "Tushar Riyat";
                        break;
                    case 101816019:
                        stdname = "Siddharth Budhwar";
                        break;
                    case 101816030:
                        stdname = "Ishita Krishnatray";
                        break;
                    default: exit(1);
                }
                textView.setText(stdname);
                break;
            case R.id.faculty:
                if(rollnumber == 101816006 || rollnumber == 101816008 ||
                        rollnumber == 101816016 || rollnumber == 101816019
                        || rollnumber == 111816030) {
                    Intent faculty_browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.thapar.edu/faculties/category/" +
                                    "departments/computer-science-engineering-dera-bassi-campus-1"));
                    startActivity(faculty_browserIntent);
                }
                else exit(1);
                break;
            case R.id.books:
                if(rollnumber == 101816006 || rollnumber == 101816008 ||
                        rollnumber == 101816016 || rollnumber == 101816019
                        || rollnumber == 111816030) {
                    Intent books_browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://library.thapar.edu/"));
                    startActivity(books_browserIntent);
                }
                else exit(1);
                break;
            case R.id.curriculum:
                if(rollnumber == 101816006 || rollnumber == 101816008 ||
                        rollnumber == 101816016 || rollnumber == 101816019
                        || rollnumber == 111816030) {
                    Intent curriculum_browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.thapar.edu/images/" +
                                    "CSSyllabus/Group%20B%20COE.pdf"));
                    startActivity(curriculum_browserIntent);
                }
                else exit(1);
                break;
            default: exit(1);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        StudentViewModel mViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        // TODO: Use the ViewModel
    }
}