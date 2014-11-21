import arcpy
from arcpy import env
import os
import sys

env.overwriteOutput = True

try:
    # This tool makes use of a system folder with a Scripts and ToolData subfolder. 
    #  We can discover the pathname of this folder by examining the
    #  first argument to the script, which is the pathname to the script
    #  (example: "E:\examples\symbology\scripts\ExtractData.py".)  We
    #  then use this toolSharePath variable to create pathnames to our 
    #  shapefile data and layer files ("E:\examples\symbology\ToolData\points.lyr").
    #
    scriptPath      = sys.argv[0]
    toolSharePath   = os.path.dirname(os.path.dirname(scriptPath))
    dataPath        = os.path.join(toolSharePath, "ToolData")
    classLyrPath    = os.path.join(dataPath, "idw_class.lyr")
    stLyrPath  = os.path.join(dataPath, "idw_lv.lyr")
    params = arcpy.GetParameterInfo()
    #arcpy.AddMessage(classLyrPath)
    #arcpy.AddMessage(stLyrPath)
    arcpy.AddMessage("param1 symbology:"+params[1].symbology)

    flag=arcpy.GetParameterAsText(0)
    inputLayer=arcpy.GetParameterAsText(1);

    if flag=="idw_class":
	arcpy.AddMessage("flag:idw_class")
	#params[1].symbology=classLyrPath
        arcpy.ApplySymbologyFromLayer_management (inputLayer,"E:\InterpolationService\ToolData\idw_class.lyr") 
    else:
        arcpy.AddMessage("flag:idw_lv")
	#params[1].symbology=stLyrPath
        arcpy.ApplySymbologyFromLayer_management (inputLayer, "E:\InterpolationService\ToolData\idw_lv.lyr")

    arcpy.AddMessage("param1 symbology:"+params[1].symbology)
except:
    arcpy.AddError("An error occurred. " + arcpy.GetMessages(2))
