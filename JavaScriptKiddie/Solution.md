Let's analyze the JavaScript for a bit

			var bytes = [];
			$.get("bytes", function(resp) {
				bytes = Array.from(resp.split(" "), x => Number(x));
			});

			function assemble_png(u_in){
				var LEN = 16;
				var key = "0000000000000000";
				var shifter;
				if(u_in.length == LEN){
					key = u_in;
				}
				var result = [];
				for(var i = 0; i < LEN; i++){
					shifter = key.charCodeAt(i) - 48;
					for(var j = 0; j < (bytes.length / LEN); j ++){
						result[(j * LEN) + i] = bytes[(((j + shifter) * LEN) % bytes.length) + i]
					}
				}
				while(result[result.length-1] == 0){
					result = result.slice(0,result.length-1);
				}
				document.getElementById("Area").src = "data:image/png;base64," + btoa(String.fromCharCode.apply(null, new Uint8Array(result)));
				return false;
			}
Looking closely, the code makes an array based off of global array bytes[], some shifting, and then turning it into a string. Doing a bit of math, we know what the first 16 characters of the output will be

    for(int i =0;i<16;i++){
      result[i]=bytes[((shifter*16)%704)+i];
    }
And we actually DO know the first 16 bits. So we can generate an array of possible shifters. Use your favorite scripting language to find out.

This solution works for both JSKiddie 1 and 2
