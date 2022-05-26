package project.timetable_recommend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


public class StudentInfoFragment extends Fragment {
    EditText grade, subjectId;
    TextView majorNum, cultureNum;
    SeekBar seekbarMajor, seekBarCulture;
    public int numMajor = 0, numCulture = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_student_info, container, false);

        grade = rootView.findViewById(R.id.editTextGrade);
        subjectId = rootView.findViewById(R.id.editTextTextSubjectId);
        seekbarMajor = rootView.findViewById(R.id.seekBarMajorScore);
        seekBarCulture = rootView.findViewById(R.id.seekBarCultureScore);
        majorNum = rootView.findViewById(R.id.textViewMajorNum);
        cultureNum = rootView.findViewById(R.id.textViewCultureNum);

        seekbarMajor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numMajor = seekBar.getProgress();
                updateMajor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                numMajor = seekBar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                numMajor = seekBar.getProgress();
            }
        });

        seekBarCulture.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numCulture = seekBar.getProgress();
                updateCulture();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                numCulture = seekBar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                numCulture = seekBar.getProgress();
            }
        });

        return rootView;
    }

    public void updateMajor() {
        majorNum.setText(new StringBuilder().append(numMajor));
    }
    public void updateCulture() {
        cultureNum.setText(new StringBuilder().append(numCulture));
    }
}