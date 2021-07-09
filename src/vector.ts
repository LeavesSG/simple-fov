export class Vector{
    public module: number
    
    constructor(public m: number, public n: number, public p: number){
        this.module = Math.sqrt(m**2 + n**2 + p**2)
        if(this.module === 0){
            this.m = 0
            this.n = 0
            this.p = 0
        }else{
            this.m = m/this.module
            this.n = n/this.module
            this.p = p/this.module
        }
    }

    public setModule(num: number){
        this.module = num
    }

    public normalise(){
        return this.setModule(1)
    }
}

export class NormalVector extends Vector{
    constructor(public m: number, public n: number, public p: number){
        super(m,n,p)
        this.normalise()
    }
}