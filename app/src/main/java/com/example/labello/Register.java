package com.example.labello;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class Register extends Fragment {

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    EditText username, phone, email, pass, conpass;
    Button signup;

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        ViewGroup root =(ViewGroup) inflater.inflate(R.layout.register_tab_fragment, container, false);
        username = root.findViewById(R.id.name);
        phone =  root.findViewById(R.id.phnum);
        email = root.findViewById(R.id.Remail);
        pass = root.findViewById(R.id.Rpass);
        conpass = root.findViewById(R.id.Rpass);
        signup = root.findViewById(R.id.register);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e_mail = email.getText().toString().trim() ;
                String password = pass.getText().toString().trim();
                if (TextUtils.isEmpty(e_mail)){
                    email.setError("Please enter your e-mail");
                }else if (TextUtils.isEmpty(password)){
                    pass.setError("Please enter your password");
                }
                createUser(e_mail,password);
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);

            }
        });



        return root;
    }


    public void createUser(String Email , String Password){
        firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

            }
        });
    }





}
