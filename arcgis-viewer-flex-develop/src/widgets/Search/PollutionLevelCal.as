package widgets.Search
{
	import flashx.textLayout.formats.Float;

	public class PollutionLevelCal
	{
		public function PollutionLevelCal()
		{
		}
		
		public static function calPollutinLevelDemo(hm_name:String, hm_content:Number):int
		{
			var hm_level:int;
			if(hm_name=="CD")
				hm_level = hm_content/0.20;
			else if(hm_name=="HG")
				hm_level = hm_content/0.15;
			else if(hm_name=="DP_AS")
				hm_level = hm_content/15;
			else if(hm_name=="CU")
				hm_level = hm_content/35;
			else if(hm_name=="PB")
				hm_level = hm_content/35;
			else if(hm_name=="ZN")
				hm_level = hm_content/100;
			else if(hm_name=="NI")
				hm_level = hm_content/40;
			else if(hm_name=="CR")
				hm_level = hm_content/90;
			return hm_level;//
		}
	}
}