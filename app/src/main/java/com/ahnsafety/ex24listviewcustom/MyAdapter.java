package com.ahnsafety.ex24listviewcustom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// BaseAdapter 클래스는 추상메소드를 보유하고 있음.
public class MyAdapter extends BaseAdapter {

    //멤버변수
    ArrayList<Member> members;
    LayoutInflater inflater;
    //생성자메소드
    public MyAdapter(ArrayList<Member> members,LayoutInflater inflater){
        this.members= members;
        this.inflater= inflater;
    }

    //이 아답터객체가 만들어낸 View객체의 개수를 리턴
    @Override
    public int getCount() {
        return members.size();
    }

    @Override
    public Object getItem(int position) {
        return members.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //리스트뷰에 보여질 항목하나의 View를 만들어내는 메소드
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        //xml로 View 모양을 설계하고 이를 객체로 만들어서 리턴함.

        //listview_item.xml문소를 읽어와서
        //View 객체로 만들어주는(부푸리다 inflate) 객체를 이용하여 이용하여 View객체 생성

        //XML -> View객체 부풀려주는 LayoutInflater라는 직원이 필요함.
        //1. new View
        //!!재활용할 View가 없는가? 화면밖으로 나간 필요없는 파일들 관리
        if(view==null){
            view= inflater.inflate(R.layout.listview_item,null);
        }
        //2. bind View : 만들어진 뷰와 데이터를 연결

        //현재번째(position번째) View에 보여줄
        //데이터를 얻어오기
        Member member=members.get(position);

        ImageView iv= view.findViewById(R.id.item_iv);
        TextView tvName= view.findViewById(R.id.item_tv_name);
        TextView tvNation=view.findViewById(R.id.item_tv_nation);

        iv.setImageResource(member.imgID);
        tvName.setText(member.name);
        tvNation.setText(member.nation);

        //만들어진 뷰를 리턴하면 리스트뷰가 화면에 보여줌
        return view;
    }
}
