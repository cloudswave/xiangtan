import arcpy
from arcpy import env
import os
import sys

env.overwriteOutput = True

try:

    symbology=arcpy.GetParameterAsText(0)
    in_raster=arcpy.GetParameterAsText(1)
    out_rasterdataset=arcpy.GetParameterAsText(2)
    out_rasterdataset2=arcpy.GetParameterAsText(3)
    out_rasterdataset3=arcpy.GetParameterAsText(4)
    
    params = arcpy.GetParameterInfo()

    if symbology=="Classified":
	arcpy.AddMessage("symbology:Classified") 
        arcpy.CopyRaster_management(in_raster,out_rasterdataset,"#","#","#","NONE","NONE","#")
	out_rasterdataset2=out_rasterdataset;
	out_rasterdataset3=out_rasterdataset;
        #params[2].symbology="E:\InterpolationService\ToolData\symbology\Classified.lyr" 
    elif symbology=="Stretched":
        arcpy.AddMessage("symbology:Stretched")
        arcpy.CopyRaster_management(in_raster,out_rasterdataset2,"#","#","#","NONE","NONE","#")
	out_rasterdataset=out_rasterdataset2;
	out_rasterdataset3=out_rasterdataset2;
	#params[3].symbology= "E:\InterpolationService\ToolData\symbology\Stretched.lyr"
    else:
        arcpy.AddMessage("symbology:Discrete Color")
        arcpy.CopyRaster_management(in_raster,out_rasterdataset3,"#","#","#","NONE","NONE","#")
	out_rasterdataset=out_rasterdataset3;
	out_rasterdataset2=out_rasterdataset3;
	#params[4].symbology="E:\InterpolationService\ToolData\symbology\DiscreteColor.lyr"
except:
    arcpy.AddError("An error occurred. " + arcpy.GetMessages(2))



