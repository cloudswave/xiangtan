import arcpy
from arcpy import env
import os
import sys

env.overwriteOutput = True

try:

    symbology=arcpy.GetParameterAsText(0)
    in_raster=arcpy.GetParameterAsText(1)
    out_rasterdataset="E:/InterpolationService/Scratch/"+symbology+".tif"
    
    params = arcpy.GetParameterInfo()

    if symbology=="Classified":
	arcpy.AddMessage("symbology:Classified")
        arcpy.CopyRaster_management(in_raster,out_rasterdataset,"#","#","#","NONE","NONE","#")
        arcpy.SetParameter(2, out_rasterdataset)
        params[2].symbology="E:\InterpolationService\ToolData\symbology\Classified.lyr" 
    elif symbology=="Stretched":
        arcpy.AddMessage("symbology:Stretched")
        arcpy.CopyRaster_management(in_raster,out_rasterdataset,"#","#","#","NONE","NONE","#")
        arcpy.SetParameter(2, out_rasterdataset)
	params[2].symbology= "E:\InterpolationService\ToolData\symbology\Stretched.lyr"
    else:
        arcpy.AddMessage("symbology:Discrete Color")
        arcpy.CopyRaster_management(in_raster,out_rasterdataset,"#","#","#","NONE","NONE","#")
        arcpy.SetParameter(2, out_rasterdataset)
	params[2].symbology="E:\InterpolationService\ToolData\symbology\DiscreteColor.lyr"
except:
    arcpy.AddError("An error occurred. " + arcpy.GetMessages(2))



