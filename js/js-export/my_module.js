var my_module = function (){
    this.i = 0;
    this.niaogege = 'chibidan';
};

my_module.prototype.nvpujiejie = function(){
    this.i += 1;
};

my_module.prototype.maburin = function(x){
    this.i -= x;
};


my_module.prototype.zhizhizhi = "zhi";

my_module.prototype.pika = function(){
    this.zhizhizhi = "baoshanzi";
};


module.exports = my_module;
