package com.example.labello.registeration;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.labello.MainActivity;
import com.example.labello.R;
import com.example.labello.utils.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;


public class LogFragment extends Fragment {

    public LogFragment() {
        // Required empty public constructor
    }

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    EditText email, pass;
    Button login;
    float v = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_log, container, false);
        email = root.findViewById(R.id.email);
        pass = root.findViewById(R.id.pass);
        login = root.findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = email.getText().toString();
                String Password = pass.getText().toString();
                if (TextUtils.isEmpty(Email)) {
                    email.setError("Please enter your e-mail");
                } else if (TextUtils.isEmpty(Password)) {
                    pass.setError("Please enter your password");
                }
                signIn(Email, Password);

            }
        });

        email.setTranslationY(300);
        pass.setTranslationY(300);
        login.setTranslationY(300);

        email.setAlpha(v);
        pass.setAlpha(v);
        login.setAlpha(v);
        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400);
        pass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400);
        login.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400);

        return root;
    }

    public void signIn(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Constants.USER_ID = task.getResult().getUser().getUid();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                } else {
                    String error = task.getException().getLocalizedMessage().toString();
                }
            }
        });


    }


}