


SELECT * from dbo.samples 
--SELECT top 1 col+'��' from dbo.f_splitSTR('ʯ����ɽ���������', '��') order by id
--select * from 
--(
--	SELECT top 1 col from dbo.f_splitSTR('ʯ����ɽ���������', '��') order by id desc
--) cunzhu

--SELECT top 1 col+'��' from dbo.f_splitSTR('ɽ���������', '��') order by id

--select SUBSTRING(wz,1,CHARINDEX('��', wz)) town
--from SAMPLES
--where wz like '%��%'

--select SUBSTRING(wz,1,CHARINDEX('��', wz)) town
--from SAMPLES
--where wz like '%��%'

--select SUBSTRING(wz,CHARINDEX('��', wz)+1,CHARINDEX('��', wz)-CHARINDEX('��', wz)) ��
--from SAMPLES
--where wz like '%��%'

--select SUBSTRING(wz,CHARINDEX('��', wz)+1,CHARINDEX('��', wz)-CHARINDEX('��', wz)) ��
--from SAMPLES
--where wz like '%��%'


update SAMPLES set town=SUBSTRING(wz,1,CHARINDEX('��', wz)) 
where wz like '%��%'

update SAMPLES set town=SUBSTRING(wz,1,CHARINDEX('��', wz)) 
where wz like '%��%'

update SAMPLES set country=SUBSTRING(wz,CHARINDEX('��', wz)+1,CHARINDEX('��', wz)-CHARINDEX('��', wz))
where wz like '%��%'

update SAMPLES set country=SUBSTRING(wz,CHARINDEX('��', wz)+1,CHARINDEX('��', wz)-CHARINDEX('��', wz))
where wz like '%��%'


--select * from SAMPLES
--where CHARINDEX('��', wz)-CHARINDEX('��', wz) < 0

--select * from SAMPLES
--where wz like '%����%'

--update SAMPLES set wz='÷���������ҳ��������'
--where CHARINDEX('��', wz)-CHARINDEX('��', wz) < 0


--SUBSTRING (<expression>�� <starting_ position>�� length)
--CHARINDEX (<��substring_expression��>�� <expression>)