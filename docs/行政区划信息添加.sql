


SELECT * from dbo.samples 
--SELECT top 1 col+'镇' from dbo.f_splitSTR('石鼓镇山田村锡尽组', '镇') order by id
--select * from 
--(
--	SELECT top 1 col from dbo.f_splitSTR('石鼓镇山田村锡尽组', '镇') order by id desc
--) cunzhu

--SELECT top 1 col+'村' from dbo.f_splitSTR('山田村锡尽组', '村') order by id

--select SUBSTRING(wz,1,CHARINDEX('镇', wz)) town
--from SAMPLES
--where wz like '%镇%'

--select SUBSTRING(wz,1,CHARINDEX('乡', wz)) town
--from SAMPLES
--where wz like '%乡%'

--select SUBSTRING(wz,CHARINDEX('镇', wz)+1,CHARINDEX('村', wz)-CHARINDEX('镇', wz)) 村
--from SAMPLES
--where wz like '%镇%'

--select SUBSTRING(wz,CHARINDEX('乡', wz)+1,CHARINDEX('村', wz)-CHARINDEX('乡', wz)) 村
--from SAMPLES
--where wz like '%乡%'


update SAMPLES set town=SUBSTRING(wz,1,CHARINDEX('镇', wz)) 
where wz like '%镇%'

update SAMPLES set town=SUBSTRING(wz,1,CHARINDEX('乡', wz)) 
where wz like '%乡%'

update SAMPLES set country=SUBSTRING(wz,CHARINDEX('镇', wz)+1,CHARINDEX('村', wz)-CHARINDEX('镇', wz))
where wz like '%镇%'

update SAMPLES set country=SUBSTRING(wz,CHARINDEX('乡', wz)+1,CHARINDEX('村', wz)-CHARINDEX('乡', wz))
where wz like '%乡%'


--select * from SAMPLES
--where CHARINDEX('村', wz)-CHARINDEX('乡', wz) < 0

--select * from SAMPLES
--where wz like '%王家%'

--update SAMPLES set wz='梅林桥镇王家冲村滂塘组'
--where CHARINDEX('村', wz)-CHARINDEX('乡', wz) < 0


--SUBSTRING (<expression>， <starting_ position>， length)
--CHARINDEX (<’substring_expression’>， <expression>)