select p.pidx, p.ptitle, m.uidx, p.pstartdate, p.penddate, d.dmsg
from planit.member m join planit.planner p
on  m.uidx=p.uidx
left outer join planit.daily_plan d
on p.pidx=d.pidx 
where m.uidx=3
;


select *
from planit.planner p left outer join planit.daily_plan d
on p.pidx=d.pidx 
where p.uidx=5
;




select * from planit.planner;
select * from planit.member;
select * from planit.daily_plan;

INSERT INTO planit.daily_plan (dloc, dtype, pidx)
		VALUES ('부산','1','51');