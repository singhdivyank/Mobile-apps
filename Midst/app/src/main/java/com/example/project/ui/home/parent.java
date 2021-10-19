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

public class parent extends Fragment implements View.OnClickListener {

    private ParentViewModel mViewModel;

    private EditText editText;
    private TextView textView;

    String parent_name="";
    int num = 0;

    public static parent newInstance() {
        return new parent();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.parent_fragment, container, false);

        /*parent login*/
        editText = v.findViewById(R.id.admission_number);
        Button button1 = v.findViewById(R.id.confirm_parent);
        textView = v.findViewById(R.id.parent_confirm);

        /*Buttons*/

        Button button2 = v.findViewById(R.id.fee);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.confirm_parent:
                num = Integer.parseInt(editText.getText().toString());
                switch(num) {
                    case 101816006:
                        parent_name = "Proceed for Divyank Singh";
                        break;
                    case 101816008:
                        parent_name = "Proceed for Mehak Dhir";
                        break;
                    case 101816016:
                        parent_name = "Proceed for Tushar Riyat";
                        break;
                    case 101816019:
                        parent_name = "Proceed for Siddharth Budhwar";
                        break;
                    case 101816030 :
                        parent_name = "Proceed for Ishita Krishnatray";
                        break;
                    default: exit(1);
                }
                textView.setText(parent_name);
                break;
            case R.id.fee:
                if(num == 101816006 || num == 101816008 || num == 101816016 ||
                        num == 101816019 || num == 101816030) {
                    Intent fee_browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://eps.eshiksha.net/esh/index.php?plugin=Login&action=index"));
                    startActivity(fee_browserIntent);
                }
                else exit(1);
                break;
            default: exit(1);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ParentViewModel.class);
        // TODO: Use the ViewModel
    }
}