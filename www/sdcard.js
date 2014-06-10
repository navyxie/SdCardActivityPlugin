var noop = function(){};
var sdcard = {
    get:function(successCbf,errorCbf){
        cordova.exec(successCbf || noop, errorCbf || noop,"SdCardActivityPlugin","get",[]);
    }
}
module.exports = sdcard;
