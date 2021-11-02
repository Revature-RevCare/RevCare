export class Covid{
    
    private covidStatus: string;
    private vaccinationStatus: boolean;

    constructor(covidStatus:string, vaccinationStatus: boolean){
        this.covidStatus = covidStatus;
        this.vaccinationStatus = vaccinationStatus;
    }

    getCovidStatus(){
        return this.covidStatus;
    }

    getVaccinationStatus(){
        return this.vaccinationStatus;
    }

}