import { LetsbePage } from './app.po';

describe('letsbe App', function() {
  let page: LetsbePage;

  beforeEach(() => {
    page = new LetsbePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
