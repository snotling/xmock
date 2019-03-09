import {Type} from "../enum/type.enum";
export class Scenario {

  constructor(
    public id: number,
    public name: string,
    public events: Event[],
    public type: Type
  ) {  }

}
