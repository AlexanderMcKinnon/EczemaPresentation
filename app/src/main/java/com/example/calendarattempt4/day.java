package com.example.calendarattempt4;
import java.sql.*;
import java.time.LocalDate;

public class day {
    protected int Day_ID;
    protected int parent_ID;
    protected int child_ID;
    protected LocalDate date;
    protected String answers;
    String AUTH = null;
    Statement s;

    public day(){
    }

    public boolean check(int CID, LocalDate date, Statement s) throws SQLException {
        this.s = s;
        String sqlStr = "SELECT * FROM dates WHERE CID =\'"+CID+"\' and date =\'"+date+"\';";
        ResultSet rset=s.executeQuery(sqlStr);
        while(rset.next()) {
            this.Day_ID = rset.getInt("DID");
            this.parent_ID = rset.getInt("PID");
            this.child_ID = rset.getInt("CID");
            this.date = date;
            this.answers = rset.getString("Record");
        }
        if (this.answers != null){
            return true;
        } else {
            return false;
        }
    }

    public void update(String answers) throws SQLException {
        String sqlStr = "UPDATE dates SET Record\'" + answers + "\' WHERE DID = \'" + this.Day_ID +"\';";
        s.execute (sqlStr);
    }

    public void create(String answers) throws SQLException {
        String sqlStr = "INSERT INTO public.dates(cid, pid, date, record) VALUES (\'"+ this.child_ID +"\',\'"+ this.parent_ID +"\',\'"+ this.date +"\',\'"+ answers +"\');";
        s.execute (sqlStr);
    }
}
