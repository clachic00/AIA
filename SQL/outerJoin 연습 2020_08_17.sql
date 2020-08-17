select p.pidx, p.ptitle, m.uidx, p.pstartdate, p.penddate, d.dmsg
from planit.member m join planit.planner p
on  m.uidx=p.uidx
left outer join planit.daily_plan d
on p.pidx=d.pidx 
where m.uidx=3
;

select * from planit.planner;
select * from planit.member;
select * from planit.daily_plan;
