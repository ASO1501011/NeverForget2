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

public class PropertyFragment extends Fragment {
    public static PropertyFragment newInstance(Context context) {
        PropertyFragment fragment = new PropertyFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_property,null);
        return root;
    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("property", Context.MODE_PRIVATE);
        String carNum = prefs.getString("carNum","");
        int phoneNum = prefs.getInt("phoneNum",0);

        EditText edText1 = (EditText) getView().findViewById(R.id.editText);
        if(carNum.length() != 0){
            edText1.setText(carNum);
        }
        EditText edText2 = (EditText) getView().findViewById(R.id.editText2);
        if(phoneNum != 0){
            edText2.setText(Integer.toString(phoneNum));
        }

    }

    @Override
    public void onPause(){
        super.onPause();
        EditText edText1 = (EditText) getView().findViewById(R.id.editText);
        EditText edText2 = (EditText) getView().findViewById(R.id.editText2);

        //入力された値が数字以外だった場合の例外処理
        String carNum;
        try{
            carNum = edText1.getText().toString();
        }catch (NumberFormatException e){
            carNum = "";
        }

        int phoneNum;
        try{
            phoneNum = Integer.parseInt(edText2.getText().toString());
        }catch (NumberFormatException e){
            phoneNum = 0;
        }

        //保存
        SharedPreferences prefs = this.getActivity().getSharedPreferences("property",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("carNum",carNum);
        editor.putInt("phoneNum",phoneNum);
        //editor.commit();
        //非同期で行う
        editor.apply();
    }



}
