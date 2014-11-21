import arcpy
from arcpy import env
import os
import sys

env.overwriteOutput = True

try:

    symbology=arcpy.GetParameterAsText(0)
    inputLayer=arcpy.GetParameterAsText(1);
    params = arcpy.GetParameterInfo()

    if symbology=="Classified":
	arcpy.AddMessage("symbology:Classified")
        params[1].symbology="E:\InterpolationService\ToolData\symbology\Classified.lyr"
	params[2].symbology="E:\InterpolationService\ToolData\symbology\Classified.lyr"
        #arcpy.ApplySymbologyFromLayer_management (inputLayer,"E:\InterpolationService\ToolData\symbology\Classified.lyr") 
    elif symbology=="Stretched":
        arcpy.AddMessage("symbology:Stretched")
	params[1].symbology= "E:\InterpolationService\ToolData\symbology\Stretched.lyr"
	params[2].symbology= "E:\InterpolationService\ToolData\symbology\Stretched.lyr"
        #arcpy.ApplySymbologyFromLayer_management (inputLayer, "E:\InterpolationService\ToolData\symbology\Stretched.lyr")
    else:
        arcpy.AddMessage("symbology:Discrete Color")
	params[1].symbology="E:\InterpolationService\ToolData\symbology\DiscreteColor.lyr"
	params[2].symbology="E:\InterpolationService\ToolData\symbology\DiscreteColor.lyr"
        #arcpy.ApplySymbologyFromLayer_management (inputLayer, "E:\InterpolationService\ToolData\symbology\DiscreteColor.lyr")
except:
    arcpy.AddError("An error occurred. " + arcpy.GetMessages(2))
