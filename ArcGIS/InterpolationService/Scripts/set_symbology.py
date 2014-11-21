import arcpy
from arcpy import env
import os
import sys

env.overwriteOutput = True

try:

    symbology=arcpy.GetParameterAsText(0)
    inputLayer=arcpy.GetParameterAsText(1);

    if symbology=="Classified":
	arcpy.AddMessage("symbology:Classified")
        arcpy.ApplySymbologyFromLayer_management (inputLayer,"E:\InterpolationService\ToolData\symbology\Classified.lyr") 
    elif symbology=="Stretched":
        arcpy.AddMessage("symbology:Stretched")
        arcpy.ApplySymbologyFromLayer_management (inputLayer, "E:\InterpolationService\ToolData\symbology\Stretched.lyr")
    else:
        arcpy.AddMessage("symbology:Discrete Color")
        arcpy.ApplySymbologyFromLayer_management (inputLayer, "E:\InterpolationService\ToolData\symbology\DiscreteColor.lyr")
except:
    arcpy.AddError("An error occurred. " + arcpy.GetMessages(2))
