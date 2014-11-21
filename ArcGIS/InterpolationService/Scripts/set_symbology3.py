import arcpy
from arcpy import env
from arcpy.sa import *
import os
import sys

env.overwriteOutput = True

try:

    symbology=arcpy.GetParameterAsText(3)
    out=arcpy.arcpy.GetParameterAsText(4)

    outIDW = Idw(arcpy.GetParameterAsText(1), arcpy.GetParameterAsText(0), "#",arcpy.GetParameterAsText(2),"VARIABLE 12")
    outIDW.save(out)
    params = arcpy.GetParameterInfo()

    if symbology=="Classified":
	arcpy.AddMessage("symbology:Classified")
        params[4].symbology="E:\InterpolationService\ToolData\symbology\Classified.lyr"
	params[4].symbology="E:\InterpolationService\ToolData\symbology\Classified.lyr"
        #arcpy.ApplySymbologyFromLayer_management ("E:/InterpolationService/Scratch/temp","E:\InterpolationService\ToolData\symbology\Classified.lyr") 
    elif symbology=="Stretched":
        arcpy.AddMessage("symbology:Stretched")
	params[4].symbology= "E:\InterpolationService\ToolData\symbology\Stretched.lyr"
	params[4].symbology= "E:\InterpolationService\ToolData\symbology\Stretched.lyr"
        #arcpy.ApplySymbologyFromLayer_management ("E:/InterpolationService/Scratch/temp", "E:\InterpolationService\ToolData\symbology\Stretched.lyr")
    else:
        arcpy.AddMessage("symbology:Discrete Color")
	params[4].symbology="E:\InterpolationService\ToolData\symbology\DiscreteColor.lyr"
	params[4].symbology="E:\InterpolationService\ToolData\symbology\DiscreteColor.lyr"
        #arcpy.ApplySymbologyFromLayer_management ("E:/InterpolationService/Scratch/temp", "E:\InterpolationService\ToolData\symbology\DiscreteColor.lyr")
except:
    arcpy.AddError("An error occurred. " + arcpy.GetMessages(2))
