package com.esri.viewer
{
	import com.esri.ags.SpatialReference;  
	import com.esri.ags.geometry.Extent;  
	import com.esri.ags.geometry.MapPoint;  
	import com.esri.ags.layers.TiledMapServiceLayer;  
	import com.esri.ags.layers.supportClasses.LOD;  
	import com.esri.ags.layers.supportClasses.TileInfo;  
	
	import flash.net.URLRequest;  
	
	//扩展TiledMapServiceLayer图层实现加载google地图  
	public class GoogleMapLayers extends TiledMapServiceLayer  
	{  
		private var _tileInfo:TileInfo=new TileInfo();  
		private var _baseURL:String="";  
		public var mapType:String="";   
		
		public function GoogleMapLayers()  
		{  
			super();  
			buildTileInfo();  
			setLoaded(true);  
		}  
		
		override public function get fullExtent():Extent  
		{  
			return new Extent(-20037508.342787, -20037508.342787, 20037508.342787, 20037508.342787, new SpatialReference(102113));  
		}  
		
		override public function get initialExtent():Extent  
		{  
			return new Extent(-20037508.342787, -20037508.342787, 20037508.342787, 20037508.342787, new SpatialReference(102113));  
		}  
		
		override public function get spatialReference():SpatialReference  
		{  
			return new SpatialReference(102113);  
		}  
		
		override public function get tileInfo():TileInfo  
		{  
			return _tileInfo;  
		}  
		
		//获取矢量地图  
		override protected function getTileURL(level:Number, row:Number, col:Number):URLRequest  
		{              
			var s:String = "Galileo".substring(0, ((3 * x + y) % 8));   
			var url:String;   
			
			//获取矢量地图               
			if(mapType == "vector")                   
			{                   
				url = "http://mt"+(col%4)+".google.cn/vt/lyrs=m@158000000&hl=zh-CN&gl=cn&" +                       
					"x=" + col + "&" +                       
					"y=" + row + "&" +                   
					"z=" + level+ "&" +                   
					"s=" + s;                   
			}                   
				
				//获取地形图  
			else if(mapType == "terrain")                   
			{                   
				url = "http://mt"+(col%4)+".google.cn/vt/lyrs=t@128,r@177000000&hl=zh-CN&gl=cn&" +                       
					"x=" + col + "&" +                       
					"y=" + row + "&" +                       
					"z=" + level+ "&" +                       
					"s=" + s;   
			}  
				
				//获取影像地图  
			else if(mapType == "image")                   
			{                   
				url = "http://mt"+(col%4)+".google.cn/vt/lyrs=s@101&hl=zh-CN&gl=cn&" +                       
					"x=" + col + "&" +                       
					"y=" + row + "&" +                       
					"z=" + level+ "&" +                       
					"s=" + s;                   
			}   
				
				//获取道路等POI，和影像地图配合使用       
			else if(mapType == "poi")              
			{                   
				url = "http://mt"+(col%4)+".google.cn/vt/imgtp=png32&lyrs=h@169000000&hl=zh-CN&gl=cn&" +                       
					"x=" + col + "&" +                       
					"y=" + row + "&" +                       
					"z=" + level+ "&" +                       
					"s=" + s;                   
			}   
			
			return new URLRequest(url);  
		}  
		
		private function buildTileInfo():void  
		{  
			_tileInfo.height=256;  
			_tileInfo.width=256;  
			_tileInfo.origin=new MapPoint(-20037508.342787, 20037508.342787);  
			_tileInfo.spatialReference=new SpatialReference(102113);  
			_tileInfo.lods = [  
				new LOD(0, 156543.033928, 591657527.591555),   
				new LOD(1, 78271.5169639999, 295828763.795777),   
				new LOD(2, 39135.7584820001, 147914381.897889),   
				new LOD(3, 19567.8792409999, 73957190.948944),   
				new LOD(4, 9783.93962049996, 36978595.474472),   
				new LOD(5, 4891.96981024998, 18489297.737236),   
				new LOD(6, 2445.98490512499, 9244648.868618),   
				new LOD(7, 1222.99245256249, 4622324.434309),   
				new LOD(8, 611.49622628138, 2311162.217155),   
				new LOD(9, 305.748113140558, 1155581.108577),   
				new LOD(10, 152.874056570411, 577790.554289),   
				new LOD(11, 76.4370282850732, 288895.277144),   
				new LOD(12, 38.2185141425366, 144447.638572),   
				new LOD(13, 19.1092570712683, 72223.819286),   
				new LOD(14, 9.55462853563415, 36111.909643),   
				new LOD(15, 4.77731426794937, 18055.954822),  
				new LOD(16, 2.38865713397468, 9027.977411),   
				new LOD(17, 1.19432856685505, 4513.988705),   
				new LOD(18, 0.597164283559817, 2256.994353),  
				new LOD(19, 0.298582141647617, 1128.497176)  
			];  
		}  
	} 
}