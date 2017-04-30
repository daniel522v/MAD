package com.example.mad.lab2;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;




public class Invite_Activity extends AppCompatActivity {


    private EditText invite_text;
    private String group_id;
    private String to;
    private Boolean email_exist;
    private String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);

        invite_text=(EditText) findViewById(R.id.invite_text);

        String GroupID;
        Bundle bundle = getIntent().getExtras();
        GroupID =bundle.getString("GroupID");
        group_id= GroupID;


        //sendEmail(invite_text.toString(),"invitation to the best group ever",group_id);

    }
    public void invite_button(View view){
        to= invite_text.getText().toString();
        invitar(to,group_id);
    }

    public void invitar(final String to, final String mes) {




        /////// 29 abril juego


            Firebase firebase = new Firebase(Config.FIREBASE_URL).child("Users");
            firebase.orderByChild("email").equalTo(to).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snap) {

               Log.d("snap: ",  "*************************************************************");
               Log.d("order by child email:", snap.toString());
                    Log.d("exist email:", String.valueOf(snap.exists()));

                    if (snap.exists()) {
                        email_exist=true;
                        Firebase ref_group = new Firebase(Config.FIREBASE_URL).child("Groups").child(group_id).child("members");


                        HashMap<String, String> look_email = (HashMap<String, String>) snap.getValue();


                        userID=look_email.keySet().toString().substring(1, look_email.keySet().toString().length()-1);

                        ref_group.child(userID).setValue(new member_class(userID));    //add a group member



                        Firebase modif_usr = new Firebase(Config.FIREBASE_URL).child("Users").child(userID).child("groups");

                        modif_usr.push().setValue(new group_name_class(group_id));



                    }
                    else { //email does not exist
                        Firebase ref = new Firebase(Config.FIREBASE_URL).child("Invitations").push();

                        //Getting values to store
                        String mail = to;
                        Long tsLong = System.currentTimeMillis()/1000;
                        Number timestamp = tsLong;
                        String group = mes;
                        //String key ref.push().getKey();

                        ref.setValue(new invitation_class(mail,timestamp,group)); //add the invitation


                        String[] TO = {to};

                        Intent emailIntent = new Intent(Intent.ACTION_SEND);
                        emailIntent.setData(Uri.parse("mailto:"));
                        emailIntent.setType("text/plain");
                        String mess="You have an invitation to join the group "+mes+" use this link Https://example.com/"+ ref.getKey().toString() +" for joining. If you dont have our app install it by using this link (HERE LINK TO GOOGLE PLAY STORE).";
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);

                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                        emailIntent.putExtra(Intent.EXTRA_TEXT,mess);



                        try {
                            startActivity(Intent.createChooser(emailIntent, "Send mail..."));

                            Log.i("Finished sending email", "");

                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(Invite_Activity.this,
                                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
                        }


                    }


                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });






        //////// 29 abril juego fin
        /////////////////////////////////////////////////////////////////////////////////////
        ///////////// INVITE SOMEONE AND ADD the data TO A TEMPORAL DATABASE
        Firebase.setAndroidContext(this);









        /////////////////////////////////////////////////////////////////////////////////////////
        finish();

    }

}


class group_name_class{

    public String group;
    public group_name_class(String group) {
        this.group=group;
    }

}
