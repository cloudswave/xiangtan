import arcpy
from arcpy import env
import os
import sys

env.overwriteOutput = True

try:

    symbology=arcpy.GetParameterAsText(0)
    Classified=arcpy.GetParameterAsText(1)
    Stretched=arcpy.GetParameterAsText(2)
    DiscreteColor=arcpy.GetParameterAsText(3)
    
    params = arcpy.GetParameterInfo()

    if symbology=="Classified":
	arcpy.AddMessage("symbology:Classified")
        arcpy.SetParameter(1,"true")
        arcpy.SetParameter(2,"false")
        arcpy.SetParameter(3,"false")
    elif symbology=="Stretched":
        arcpy.AddMessage("symbology:Stretched")
        arcpy.SetParameter(1,"false")
        arcpy.SetParameter(2,"true")
        arcpy.SetParameter(3,"false")
    else:
        arcpy.AddMessage("symbology:Discrete Color")
        arcpy.SetParameter(1,"false")
        arcpy.SetParameter(2,"false")
        arcpy.SetParameter(3,"true")
except:
    arcpy.AddError("An error occurred. " + arcpy.GetMessages(2))



