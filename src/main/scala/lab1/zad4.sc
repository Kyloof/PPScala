def militaryMinutes(x: Int, y: Int, time: String): String = {

  if (x > 11) then
    return "Wrong time value: " + x.toString

  if (time != "AM" ) then
    if (time != "PM") then
      return "Wrong time value"


  val hour = if (time == "PM") (x + 12).toString else if (x>10) x.toString else "0" + x.toString
  val minute = if (y<10) "0" + y.toString else y.toString
  hour + " : " + minute
}

militaryMinutes(11,59,"PM")
militaryMinutes(1,59,"AM")
militaryMinutes(12,59,"AM")