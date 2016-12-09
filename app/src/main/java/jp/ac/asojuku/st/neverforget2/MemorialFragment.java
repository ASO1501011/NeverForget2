package jp.ac.asojuku.st.neverforget2;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class MemorialFragment extends Fragment {
    public static MemorialFragment newInstance(Context context) {
        MemorialFragment fragment = new MemorialFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_memorial,null);
        return root;
    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("memorial", Context.MODE_PRIVATE);
        String wedding = prefs.getString("wedding","");
        String birthday_w = prefs.getString("birthday_w","");
        String birthday_c_1 = prefs.getString("birthday_c_1","");
        String birthday_c_2 = prefs.getString("birthday_c_2","");
        String birthday_c_3 = prefs.getString("birthday_c_3","");

        EditText edText1 = (EditText) getView().findViewById(R.id.editText);
        if(wedding.length() != 0){
            edText1.setText(wedding);
        }

        EditText edText2 = (EditText) getView().findViewById(R.id.editText2);
        if(birthday_w.length() != 0){
            edText2.setText(birthday_w);
        }

        EditText edText3 = (EditText) getView().findViewById(R.id.editText3);
        if(birthday_c_1.length() != 0){
            edText3.setText(birthday_c_1);
        }

        EditText edText4 = (EditText) getView().findViewById(R.id.editText4);
        if(birthday_c_2.length() != 0){
            edText4.setText(birthday_c_2);
        }

        EditText edText5 = (EditText) getView().findViewById(R.id.editText5);
        if(birthday_c_3.length() != 0){
            edText5.setText(birthday_c_3);
        }

    }

    @Override
    public void onPause(){
        super.onPause();
        EditText edText1 = (EditText) getView().findViewById(R.id.editText);
        EditText edText2 = (EditText) getView().findViewById(R.id.editText2);
        EditText edText3 = (EditText) getView().findViewById(R.id.editText3);
        EditText edText4 = (EditText) getView().findViewById(R.id.editText4);
        EditText edText5 = (EditText) getView().findViewById(R.id.editText5);

        //入力された値が数字以外だった場合の例外処理
        String wedding;
        try{
            wedding = edText1.getText().toString();
        }catch (Exception e){
            wedding = "";
        }
        String birth_w;
        try{
            birth_w = edText2.getText().toString();
        }catch (Exception e){
            birth_w = "";
        }
        String birth_c_1;
        try{
            birth_c_1 = edText3.getText().toString();
        }catch (Exception e){
            birth_c_1 = "";
        }
        String birth_c_2;
        try{
            birth_c_2 = edText4.getText().toString();
        }catch (Exception e){
            birth_c_2 = "";
        }
        String birth_c_3;
        try{
            birth_c_3 = edText5.getText().toString();
        }catch (Exception e){
            birth_c_3 = "";
        }

        //保存
        SharedPreferences prefs = this.getActivity().getSharedPreferences("memorial",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("wedding",wedding);
        editor.putString("birthday_w",birth_w);
        editor.putString("birthday_c_1",birth_c_1);
        editor.putString("birthday_c_2",birth_c_2);
        editor.putString("birthday_c_3",birth_c_3);
        //editor.commit();
        //非同期で行う
        editor.apply();
    }



}
