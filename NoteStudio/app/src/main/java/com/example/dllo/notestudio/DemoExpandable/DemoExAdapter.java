package com.example.dllo.notestudio.DemoExpandable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.dllo.notestudio.R;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dllo on 16/11/3.
 */

public class DemoExAdapter extends BaseExpandableListAdapter {
    private ArrayList<String> father;
    //1111
    private ArrayList<ArrayList<String>> son;
    private Context context;

    public static final int TYPEFATHER = 0;
    public static final int TYPESON = 1;
    public static final int TYPECOUNT = 2;


    public DemoExAdapter(Context context) {
        this.context = context;
    }

    public DemoExAdapter setFather(ArrayList<String> father) {
        this.father = father;
        notifyDataSetChanged();
        return this;
    }

    public DemoExAdapter setSon(ArrayList<ArrayList<String>> son) {
        this.son = son;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public int getGroupCount() {
        return father!=null&&father.size()>0?father.size():0;
    }
//123
    @Override
    public int getChildrenCount(int i) {
        return son.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return father.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return son.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override//一般不用
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderFATHER holderFATHER = null;

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.demo_expandable_father,viewGroup,false);
            holderFATHER = new ViewHolderFATHER(view);
            view.setTag(holderFATHER);
        }else {
            holderFATHER = (ViewHolderFATHER) view.getTag();
        }
holderFATHER.tv1.setText(father.get(i));

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderSon holderSon = null ;
        if (view==null) {
        view = LayoutInflater.from(context).inflate(R.layout.demo_expandable_son,viewGroup,false);
            holderSon = new ViewHolderSon(view);
            view.setTag(holderSon);

        }else {
            holderSon = (ViewHolderSon) view.getTag();

        }
        holderSon.tv2.setText(son.get(i).get(i1));

        return view;
    }
//子列表可否被点击
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
    class ViewHolderFATHER {
        private TextView tv1 ;

        public ViewHolderFATHER(View view) {
            tv1 = (TextView) view.findViewById(R.id.exp_father);
        }
    }

    class ViewHolderSon {
        private TextView tv2 ;

        public ViewHolderSon(View view) {
            tv2 = (TextView) view.findViewById(R.id.exp_son);

        }
    }


}
