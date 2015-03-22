package com.iitresourcemanager.iitiresourcemanager;

/**
 * Created by aayushi on 16/3/15.
 */
public class HistoryEntryData {
    private long columnId;
    private String rollNumber;
    private String item;
    private String time;
    private String date;
    private String type;
    public long getColumnId(){
        return columnId;
    }
    public String getRollNumber(){
        return rollNumber;
    }
    public String getItem(){
        return item;
    }
    public String getTime(){
        return time;
    }
    public String getDate(){
        return date;
    }
    public String getType(){
        return type;
    }
    public void setColumnId(long id){
        columnId=id;
    }
    public void setRollNumber(String rollNo){
        rollNumber=rollNo;
    }
    public void setItem(String it){
        item=it;
    }
    public void setTime(String tm){
        time=tm;
    }
    public void setDate(String dt){
        date=dt;
    }
    public void setType(String tp){
        type=tp;
    }

}
