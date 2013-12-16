
		<script type="text/javascript" language="javascript">
			$().ready(function(){
				$(".img").click(function(){
					$(".leftnav").toggle();
					
					$.ajax({
						type:"get",
						url: "./customer_guangzhou!leftDisplay.action",  //查询一些相关的数据
						dataType: "html"
					});
					
				});

				$(".leftlist").click(function(){
					$(".leftms").hide();
					var kk =$(this).next();
					for(var i = 0 ; i<20;i++){
						if(kk.hasClass("leftlist")){
							break;
						}
						kk.show();
						kk = kk.next();
					}	
				});
			});
		

		</script>