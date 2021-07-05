package Helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class UtilsDate {
  public static String FORMAT_TODAY = "^TODAY$";
  public static String FORMAT_NOW = "^NOW$";
  public static String FORMAT_NOW_ADD_YMDH = "^NOW[+-][0-9]*[YMDH]$";
  public static String FORMAT_TODAY_HH_MN = "^TODAY_([01]?[0-9]|2[0-3]):[0-5][0-9]$";
  public static String FORMAT_TODAY_ADD_YMDH = "^TODAY[+-][0-9]*[YMDH]$";
  public static String FORMAT_TODAY_ADD_YMDH_AT_HH_MN = "^TODAY[+-][0-9]*[YMDH]_([01]?[0-9]|2[0-3]):[0-5][0-9]$";

  private static Pattern PATTERN_TODAY = Pattern.compile(FORMAT_TODAY);
  private static Pattern PATTERN_TODAY_HH_MN = Pattern.compile(FORMAT_TODAY_HH_MN);
  private static Pattern PATTERN_TODAY_ADD_YMDH = Pattern.compile(FORMAT_TODAY_ADD_YMDH);
  private static Pattern PATTERN_TODAY_ADD_YMDH_AT_HH_MN = Pattern.compile(FORMAT_TODAY_ADD_YMDH_AT_HH_MN);

  private static Pattern PATTERN_NOW = Pattern.compile(FORMAT_NOW);
  private static Pattern PATTERN_NOW_ADD_YMDH = Pattern.compile(FORMAT_NOW_ADD_YMDH);


  // format is a keyword which represents the expected Date or  dateTime
  /*
  format :  2020-02-03 => 2020-02-03
  format :  TODAY => 2020-02-03
  format :  TODAY_00:00 => 2020-02-03T00:00Z
  format :  TODAY_11:21 => 2020-02-03T11:21Z
  format :  TODAY-6Y => 2014-02-03
  format :  TODAY-17Y => 2003-02-03
  format :  TODAY-6D_15:00 => 2020-01-28T15:00Z
  format :  TODAY-6M_15:00 => 2019-08-03T15:00Z
  format :  NOW => 2020-02-03T15:35:00Z
  format :  NOW+3D => 2020-02-06T15:35:00Z
  */
  public static String getDateForBrowser(String format) {
    String strDate = "";
    if (format == null) {
      return null;
    }
    Date date = Calendar.getInstance().getTime();
    if (format.startsWith("NOW") || format.startsWith("TODAY")) {

      if (PATTERN_TODAY.matcher(format).matches()) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        strDate = dateFormat.format(date);
      } else if (PATTERN_TODAY_HH_MN.matcher(format).matches()) {

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");


        strDate = dateFormat.format(date);
        String strH;
        int h = Integer.parseInt(format.substring(6, 8));

        if (h > 11) {
          strH = "" + (h - 12) + ":" + format.substring(9, 11) + " PM";
        } else {
          strH = "" + (h) + ":" + format.substring(9, 11) + " AM";
        }
        strDate += ", " + strH;
      } else if (PATTERN_TODAY_ADD_YMDH.matcher(format).matches()) {
        strDate = getextrDate(format.substring(5), "MM/dd/yyyy");
      } else if (PATTERN_TODAY_ADD_YMDH_AT_HH_MN.matcher(format).matches()) {
        strDate = getextrDate(format.substring(5, format.indexOf("_")), "MM/dd/yyyy");
        String f = format.substring(format.indexOf("_") + 1);
        String strH;
        int h = Integer.parseInt(f.substring(0, 2));

        if (h > 11) {
          strH = "" + (h - 12) + ":" + f.substring(3, 5) + " PM";
        } else {
          strH = "" + (h) + ":" + f.substring(3, 5) + " AM";
        }
        strDate += ", " + strH;
      } else if (PATTERN_NOW.matcher(format).matches()) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy', 'h:mm aa");
        strDate = dateFormat.format(date);
      } else if (PATTERN_NOW_ADD_YMDH.matcher(format).matches()) {
        strDate = getextrDate(format.substring(3), "MM/dd/yyyy', 'h:mm aa");
      }
      // else ?? TODO throw
      return strDate;
    } else {
      strDate = format; // no traslation expected
    }
    return strDate;
  }

  /*
    Method used to ADD Y,M, D of the day, and return the computed date with the format described in parameter
   */
  private static String getextrDate(String param, String format) {
    String strDate = "";
    Date date = Calendar.getInstance().getTime();
    // get number to add and get Unit
    int n = Integer.parseInt(param.substring(0, param.length() - 1));
    char unit = param.charAt(param.length() - 1);
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    if (unit == 'Y')
      c.add(Calendar.YEAR, n);
    else if (unit == 'M')
      c.add(Calendar.MONTH, n);
    else if (unit == 'D')
      c.add(Calendar.DATE, n);
    else if (unit == 'H')
      c.add(Calendar.HOUR, n);
    date = c.getTime();
    // manipulate date

    DateFormat dateFormat = new SimpleDateFormat(format);
    strDate = dateFormat.format(date);
    return strDate;
  }

  public static String getDateForDatabase(String format) {
    String strDate = "";
    if (format == null) {
      return null;
    }
    Date date = Calendar.getInstance().getTime();
    if (format.startsWith("NOW") || format.startsWith("TODAY")) {

      if (PATTERN_TODAY.matcher(format).matches()) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        strDate = dateFormat.format(date);
      } else if (PATTERN_TODAY_HH_MN.matcher(format).matches()) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        strDate = dateFormat.format(date);
        strDate += "T" + format.substring(6, 8) + ":" + format.substring(9, 11) + ":00Z";
      } else if (PATTERN_TODAY_ADD_YMDH.matcher(format).matches()) {
        strDate = getextrDate(format.substring(5), "yyyy-MM-dd");
      } else if (PATTERN_TODAY_ADD_YMDH_AT_HH_MN.matcher(format).matches()) {
        strDate = getextrDate(format.substring(5, format.indexOf("_")), "yyyy-MM-dd");
        String f = format.substring(format.indexOf("_") + 1);
        strDate += "T" + f.substring(0, 2) + ":" + f.substring(3, 5) + ":00Z";

      } else if (PATTERN_NOW.matcher(format).matches()) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm':00Z'");
        strDate = dateFormat.format(date);
      } else if (PATTERN_NOW_ADD_YMDH.matcher(format).matches()) {
        strDate = getextrDate(format.substring(3), "yyyy-MM-dd'T'HH:mm':00Z'");
      }
      // else ?? TODO throw
      return strDate;
    } else {
      strDate = format; // no traslation expected
    }
    return strDate;
  }


  public static String getExpirationDate( String dt ) {
    String strDate = dt;
    if (PATTERN_TODAY_ADD_YMDH.matcher(dt).matches()) {
      strDate = getextrDate(dt.substring(5), "dd/MM/yyyy");
    }
    return strDate;
  }
}