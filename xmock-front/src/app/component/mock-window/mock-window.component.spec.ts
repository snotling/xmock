import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MockWindowComponent } from './component/mock-window.component.ts';

describe('MockWindowComponent', () => {
  let component: MockWindowComponent;
  let fixture: ComponentFixture<MockWindowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MockWindowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MockWindowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
